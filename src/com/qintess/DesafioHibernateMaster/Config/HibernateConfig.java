package com.qintess.DesafioHibernateMaster.Config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.qintess.DesafioHibernateMaster.Model.Cerveja;
import com.qintess.DesafioHibernateMaster.Model.Cidade;
import com.qintess.DesafioHibernateMaster.Model.Cliente;
import com.qintess.DesafioHibernateMaster.Model.Estado;
import com.qintess.DesafioHibernateMaster.Model.Estilo;
import com.qintess.DesafioHibernateMaster.Model.Grupo;
import com.qintess.DesafioHibernateMaster.Model.GrupoPermissao;
import com.qintess.DesafioHibernateMaster.Model.ItemVenda;
import com.qintess.DesafioHibernateMaster.Model.Permissao;
import com.qintess.DesafioHibernateMaster.Model.Usuario;
import com.qintess.DesafioHibernateMaster.Model.UsuarioGrupo;
import com.qintess.DesafioHibernateMaster.Model.Venda;

public class HibernateConfig {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {

			try {

				Configuration configuration = new Configuration();

				Properties prop = new Properties();

				// config de conexao ao banco de dados
				prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				prop.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate?serverTimezone=GMT-03:00");
				prop.put(Environment.USER, "sa");
				prop.put(Environment.PASS, "asd123456!");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

				prop.put(Environment.SHOW_SQL, "true");
				prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");


				configuration.setProperties(prop);

				// configuration.addAnnotatedClass(Cliente.class);
				configuration.addAnnotatedClass(Cerveja.class);
				configuration.addAnnotatedClass(Cidade.class);
				configuration.addAnnotatedClass(Cliente.class);
				configuration.addAnnotatedClass(Estado.class);				
				configuration.addAnnotatedClass(Estilo.class);
				configuration.addAnnotatedClass(Grupo.class);
				configuration.addAnnotatedClass(ItemVenda.class);
				configuration.addAnnotatedClass(Permissao.class);				
				configuration.addAnnotatedClass(Venda.class);
				configuration.addAnnotatedClass(Usuario.class);
				configuration.addAnnotatedClass(GrupoPermissao.class);
				configuration.addAnnotatedClass(UsuarioGrupo.class);			

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return sessionFactory;
	}

}
