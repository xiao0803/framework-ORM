package com.my.app.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.my.app.domain.Weibo;
import com.my.app.vo.WeiboVo;

@Repository
public class WeiboDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Weibo> searchWeiboByEm(String username, String weiboText, Date startDate, Date endDate, int pageNo, int pageSize) {
        StringBuffer jpql = new StringBuffer("select w from Weibo w join fetch w.user u left join fetch w.comments c where 1=1 ");
        Map<String,Object> paramMap = new HashMap<>();
        if(!StringUtils.isEmpty(username)){
            jpql.append(" and u.username = :username");
            paramMap.put("username",username);
        }
        if(!StringUtils.isEmpty(weiboText)){
            jpql.append(" and w.weiboText like :weiboText");
            paramMap.put("weiboText","%"+weiboText+"%");
        }
        if(startDate!=null){
            jpql.append(" and w.createDate >= :startDate");
            paramMap.put("startDate",startDate);
        }
        if(endDate != null){
            jpql.append(" and w.createDate <= :endDate");
            paramMap.put("endDate",endDate);
        }

        Query query = entityManager.createQuery(jpql.toString());
        Set<String> keys = paramMap.keySet();
        for (String keyItem : keys) {
            query.setParameter(keyItem,paramMap.get(keyItem));
        }
        return query.setFirstResult(pageNo*pageSize).setMaxResults(pageSize).getResultList();
    }
    
    //jpql语句查询
    @Transactional(readOnly = true)
    public List<Map<String, Weibo>> searchWeibo1() {
    	StringBuffer jpql = new StringBuffer("select w from Weibo w  where 1=1 ");
        Query query = entityManager.createQuery(jpql.toString());
        List<Map<String, Weibo>> list = query.getResultList();
        System.out.println(list);
        System.out.println("@@@@@@@@@:" + list.get(0).get("weiboText"));
        
        return null;
    }
    
    //原生的SQL语句查询
    @Transactional(readOnly = true)
    public List<WeiboVo> searchWeibo2(String weibo_text) {
    	StringBuffer jpql = new StringBuffer("SELECT w.weibo_id as weiboId, w.user_id as userId FROM weibo w  where w.weibo_text like :weibo_text");
    	Session session = entityManager.unwrap(Session.class);
    	NativeQuery query = session.createNativeQuery(jpql.toString());
    	//给查询出来的字段设置类型，此处一定要有，否则会报错
    	query.addScalar("weiboId", StandardBasicTypes.LONG);
    	query.addScalar("userId", StandardBasicTypes.LONG);
    	//设置接受结果的实体
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(WeiboVo.class));
        //设置SQL里面的参数；注意：名字一定要一致
        query.setParameter("weibo_text", weibo_text);
        //获取查询结果
    	List<WeiboVo> list = query.getResultList();
    	WeiboVo a = list.get(0);
    	long WeiboId = a.getWeiboId();
        //关闭
    	entityManager.close();
        return list;
    }

}
