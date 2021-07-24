package com.lombok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.lombok.dao.ProduitRepository;
import com.lombok.entities.Produit;


@SpringBootApplication
public class MyCatalogueApplication implements CommandLineRunner {
	@Autowired
	public ProduitRepository produitRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyCatalogueApplication.class, args);	
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		produitRepository.save(new Produit(null,"Ordi HP Envy",18,6500));
		produitRepository.save(new Produit(null,"Imprimante HP 1025",11,350));
		produitRepository.save(new Produit(null,"Smartphone P40",140,1500));
		
		Page<Produit> produits=produitRepository.findByDesignationContains("r",PageRequest.of(0, 2));
		System.out.println(produits.getSize());
		System.out.println(produits.getTotalElements());
		System.out.println(produits.getTotalPages());
		produits.getContent().forEach(p->{
			System.out.println(p.toString());
		});
		
		System.out.println("-----------__---------------__-----------");
		Page<Produit> prods=produitRepository.chercher("%H%", 300, PageRequest.of(0, 2));
		System.out.println(prods.getSize());
		System.out.println(prods.getTotalElements());
		System.out.println(prods.getTotalPages());
		prods.getContent().forEach(p->{
			System.out.println(p.toString());
		});
		
	}

}
