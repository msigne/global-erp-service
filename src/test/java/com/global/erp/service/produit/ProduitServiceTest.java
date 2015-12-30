package com.global.erp.service.produit;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.camlait.global.erp.domain.enumeration.Portee;
import com.camlait.global.erp.domain.produit.CategorieProduit;
import com.camlait.global.erp.service.produit.ProduitService;

@RunWith(MockitoJUnitRunner.class)
public class ProduitServiceTest {

	@Mock
	private ProduitService service;
	private CategorieProduit categorie;

	@Before
	public void setup() {
		categorie = new CategorieProduit();
		categorie.setCategorieProduitId(1L);
		categorie.setCodeCategorieProduit("PL");
		categorie.setCategorieTaxable(true);
		categorie.setDateDeCreation(new Date());
		categorie.setDerniereMiseAJour(new Date());
		categorie.setDescriptionCategorie("Produits laitiers");
		categorie.setPortee(Portee.DETAIL);
	}

	@Test
	public void ajouterCategorieProduitTest() {
		service.ajouterCategorieProduit(categorie);
		verify(service).ajouterCategorieProduit(categorie);
		verify(service, times(1)).ajouterCategorieProduit(categorie);
	}

	@Test
	public void modifierCategorieProduitTest() {
		service.modifierCategorieProduit(categorie);
		verify(service, times(1)).modifierCategorieProduit(categorie);
	}

	@Test
	public void supprimerCategorieProduitTest() {
		service.supprimerCategorieProduit(categorie.getCategorieProduitId());
		verify(service, times(1)).supprimerCategorieProduit(eq(categorie.getCategorieProduitId()));
	}

	@Test
	public void trouverCategorieProduitTest() {
		service.obtenirCategorieProduit(categorie.getCategorieProduitId());
		verify(service, times(1)).obtenirCategorieProduit(eq(categorie.getCategorieProduitId()));
	}

	@Test
	public void listerCategorieTest() {
		service.listerCategorieProduit();
		verify(service).listerCategorieProduit();
	}
}
