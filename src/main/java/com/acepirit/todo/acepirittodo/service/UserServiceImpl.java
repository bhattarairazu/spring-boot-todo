package com.acepirit.todo.acepirittodo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.acepirit.todo.acepirittodo.entity.Role;
import com.acepirit.todo.acepirittodo.entity.User;
import com.acepirit.todo.acepirittodo.repository.RoleRepository;
import com.acepirit.todo.acepirittodo.repository.UserRepository;
import com.acepirit.todo.acepirittodo.user.CrmUser;

@Service
public class UserServiceImpl implements UserService {

		
//		@Autowired
//		private UserDao userDao;
	//	
		@Autowired
		private UserRepository userRepository;
		
//		@Autowired
//		private RoleDao roleDao;
	//	
		@Autowired
		private RoleRepository roleReposiroty;
		
		@Autowired
		private BCryptPasswordEncoder passwordEncoder;
		
		
		@Override
		@Transactional
		public User findByUserName(String userName) {
			//User muser = userDao.findByUserName(userName);
			User muser = userRepository.findByUserName(userName);
			
			return muser;
		}

		@Override
		@Transactional
		public void save(CrmUser crmUser) {
			User muser = new User();
			muser.setUserName(crmUser.getUserName());
			muser.setPassword(passwordEncoder.encode(crmUser.getPassword()));
			muser.setFirstName(crmUser.getFirstName());
			muser.setLastName(crmUser.getLastName());
			muser.setRoles(Arrays.asList(roleReposiroty.findRoleByName("ROLE_EMPLOYEE")));
			
			userRepository.save(muser);
			//userDao.save(muser);

		}
		@Override
		@Transactional
		public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
			//User user = userDao.findByUserName(userName);
			User user = userRepository.findByUserName(userName);
			
			if (user == null) {
				throw new UsernameNotFoundException("Invalid username or password.");
			}
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
					mapRolesToAuthorities(user.getRoles()));
		}

		private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
			return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		}


}
