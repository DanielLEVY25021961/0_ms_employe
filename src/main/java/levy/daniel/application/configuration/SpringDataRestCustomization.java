package levy.daniel.application.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import levy.daniel.application.model.metier.employe.IEmploye;

/**
 * CLASSE SpringDataRestCustomization :<br/>
 * Configure Spring-Data-Rest pour qu'il 
 * expose les id des objets metier lors de la serialization.<br/>
 * <strong>Configuration</strong> oblige SPRING à lire 
 * cette classe au démarrage de l'application.<br/>
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
 * @since 6 oct. 2020
 */
@Configuration
public class SpringDataRestCustomization implements RepositoryRestConfigurer {

	
	
	/**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public SpringDataRestCustomization() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public void configureRepositoryRestConfiguration(
			final RepositoryRestConfiguration pConfig) {
		
		/* expose les Id pour les IEmploye lors de la sérialization Jackson. */
		pConfig.exposeIdsFor(IEmploye.class);
		
		
		/* permet un retour dans le corps de la réponse HTTP 
		 * après une action (création d'entité, ...)*/
		pConfig.setReturnBodyOnCreate(true);
		pConfig.setReturnBodyOnUpdate(true);
		pConfig.setReturnBodyForPutAndPost(true);
		
		/* autorise les requêtes croisées (CORS REQUESTS). */
		pConfig.getCorsRegistry()
			.addMapping("/**")
			.allowedOrigins("*")
			.allowedHeaders("*")
			.allowedMethods("OPTIONS", "HEAD", "GET", "POST", "PUT", "PATCH", "DELETE");

		
	} // Fin de configureRepositoryRestConfiguration(...)._________________
	
	

} // FIN DE LA CLASSE SpringDataRestCustomization.---------------------------
