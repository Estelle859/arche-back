package com.online.eLibrairie.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.online.eLibrairie.models.LignePanier;
import com.online.eLibrairie.models.Panier;

public interface PanierRepository  extends JpaRepository<Panier, Integer>{
	@Query(value="select * from ligne_panier" +
			" left join panier on ligne_panier.panier_id = panier.id " +
			" left join client on panier.client_id = client.id " +
			" where client.nom=:client",nativeQuery = true)
			public List<LignePanier> getAllLignePanierByClient(@Param("client") String client);

	
	@Query(value="select * from ligne_panier" +
			" left join panier on ligne_panier.panier_id = panier.id " +
			" left join client on panier.client_id = client.id " +
			" where panier.id=:panier",nativeQuery = true)
			public List<LignePanier> getAllLignepanierBypanier(@Param("panier") Integer id);

	@Query(value="delete * from ligne_panier" +
			" left join panier on ligne_panier.panier_id = panier.id " +
			" left join client on panier.client_id = client.id " +
			" where ligne_panier.id=:lignepanier and client.nom=:client",nativeQuery = true)		
			public void deleteById(@Param("lignepanier") Integer id, @Param("client") String client);	

}
