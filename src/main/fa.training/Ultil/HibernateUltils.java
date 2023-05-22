package fa.training.Ultil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class HibernateUltils {

  private static SessionFactory sessionFactory;

  static {
    // Create a new ServiceRegistry object
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
    // Create metadata
    Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
    // Get the SessionFactory object from Configuration
    if (sessionFactory == null) {
      sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
