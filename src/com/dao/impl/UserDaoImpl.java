package com.dao.impl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dao.UserDao;
import com.entity.User;
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	//添加单条的信息
	public void add(User user) {
		this.getHibernateTemplate().save(user);	
	}
	
	//根据用户id查询用户的信息
	public User findById(User user){
		int id = user.getId();
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where id=?",id);
		user = list.get(0);
		return user;
	}
	
	//验证用户登录
	@Override
	public List<User> find(User user) {		
		List<User> userList = (List<User>)this.getHibernateTemplate().execute(new HibernateCallback<List<User>>() {
		@Override
			public List<User> doInHibernate(Session s) throws HibernateException {
				// TODO Auto-generated method stub
				Query query = s.createQuery("from User where name=?");
				query.setString(0, user.getName());
				List<User> list = query.list();
				return list;
			}
		});
			return userList;
	}
	
	//删除单条信息
	@Override
	public void del(User user) {
		int id = user.getId();
		User ur = this.getHibernateTemplate().get(User.class, id);
		this.getHibernateTemplate().delete(ur);
	}
	
	//修改单条信息
	@Override
	public void upd(User user) {
		System.out.println(user);
		this.getHibernateTemplate().update(user);
		
	}

	//返回分页中list集合对象
	public List<User> getByPage(final int pageIndex,final int pageSize){
		List<User> userList = this.getHibernateTemplate().execute(new HibernateCallback<List<User>>() {

			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from User");
				query.setFirstResult((pageIndex-1)*pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
		return userList;
	}
	
	//返回分页中的对象总数
	public int getCount(){
		Integer count = this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("select count(*) from User");
				Long cn = (Long)query.uniqueResult();
				int count2 = cn.intValue();
				return count2;
			}
		});
		return count;
	}

	
	
}
