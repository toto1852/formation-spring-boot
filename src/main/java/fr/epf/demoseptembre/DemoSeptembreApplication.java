package fr.epf.demoseptembre;

import fr.epf.demoseptembre.models.User;
import fr.epf.demoseptembre.persistence.UserDao;
import fr.epf.demoseptembre.models.Promotion;
import fr.epf.demoseptembre.persistence.PromotionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories
public class DemoSeptembreApplication {
  
  @Autowired
  private UserDao userDao;
  private PromotionDao promotionDao;
  
  public static void main(String[] args) {
    // Point d'entrée de l'application.
    // On dit à Spring de s'initialiser
    // Il va aller "regarder" nos classes et détecter les annotations des singletons 
    // (@Controller, @Repository, @Component, @Service, etc...)
    // Ensuite, il va construire l'arbre de dépendances et le résoudre en injectant les données dans les bonnes classes
    SpringApplication.run(DemoSeptembreApplication.class);
  }

  /**
   * On appelle cette méthode lorsque Spring a terminé son initialisation.
   * Ici, on va réinitialiser la DB et insérer 3 entrées.
   */
  @PostConstruct
  public void init() {
    userDao.deleteAll();
    userDao.save(new User(null,"Loic", "Ortola","2019"));
    userDao.save(new User(null, "Ambroise", "Soullier","2019"));
    userDao.save(new User(null, "Harry", "Covert","2019"));
    //promotionDao.deleteAll();
    //promotionDao.save(new Promotion (null, "test"));
  }
}