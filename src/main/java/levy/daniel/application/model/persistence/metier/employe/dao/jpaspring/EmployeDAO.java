package levy.daniel.application.model.persistence.metier.employe.dao.jpaspring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import levy.daniel.application.model.persistence.metier.employe.entities.jpa.Employe;

/**
 * INTERFACE EmployeDAO :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author Daniel Lévy
 * @version 1.0
 * @since 7 nov. 2020
 */
@RepositoryRestResource
public interface EmployeDAO extends JpaRepository<Employe, Long> {

	
	
} // FIN DE L'INTERFACE EmployeDAO.------------------------------------------
