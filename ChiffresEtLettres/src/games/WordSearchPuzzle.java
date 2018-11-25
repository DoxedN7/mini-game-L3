package games;

import java.io.IOException;
import java.util.Scanner;


//on considere que la 1ere case du tableau est 1-1
public final class WordSearchPuzzle extends ABSWordManagement {
	//attributs:
	private int colonneDebutMot;//coordonnees x de la 1ere lettre du mot choisit
	private int ligneDebutMot;//coordonnees y de la 1ere lettre du mot choisit
	
	private int colonneFinMot;//coordonnees x de la derniere lettre du mot choisit
	private int ligneFinMot;//coordonnees y de la derniere lettre du mot choisit
	
	private GrilleMelee grille;//la grille choisit
	private String fpath;//chemin du fichier choisit
	
	//constructeurs:
    public WordSearchPuzzle(String fpath) throws IOException {
		// TODO Auto-generated constructor stub
    	this.fpath = fpath;
    	
    	if (this.fpath.equals("Annexes/Mots_meles/Fruits.txt")) {
    		this.grille = new GrilleMelee(this.fpath,11,10);
    	}
    		
    	else if(this.fpath.equals("Annexes/Mots_meles/Legumes.txt")) {
    		this.grille = new GrilleMelee(this.fpath,14,13);
    	}
    		
    	else if(this.fpath.equals("Annexes/Mots_meles/Noel.txt") ) {
    		this.grille = new GrilleMelee(this.fpath,15,13);
    	}
    		
    	else
    		System.out.println("pas de grille a cette adresse");	
 
    	this.colonneDebutMot = 0;
    	this.ligneDebutMot = 0;
    	
    	this.colonneFinMot = 0;
    	this.ligneFinMot = 0;
    	
	}
    
	//methodes:

	@Override
	public void BidonPower() {
		// TODO Auto-generated method stub
		
	}

	public int getColonneDebutMot() {
		return colonneDebutMot;
	}

	public void setColonneDebutMot(int xdebutMot) {
		this.colonneDebutMot = xdebutMot;
	}

	public int getLigneDebutMot() {
		return ligneDebutMot;
	}

	public void setLigneDebutMot(int ydebutMot) {
		this.ligneDebutMot = ydebutMot;
	}

	public int getColonneFinMot() {
		return colonneFinMot;
	}

	public void setColonneFinMot(int xfinMot) {
		this.colonneFinMot = xfinMot;
	}

	public int getLigneFinMot() {
		return ligneFinMot;
	}

	public void setLigneFinMot(int yfinMot) {
		this.ligneFinMot = yfinMot;
	}

	public String getFpath() {
		return fpath;
	}

	public GrilleMelee getGrille() {
		return grille;
	}

	public void changeDebutMot(Scanner sc) {//permet de changer les coordonn�es du debut du mot
		int temp;
		System.out.println("saisir la ligne de la lettre du debut du mot");
		temp=sc.nextInt();
		this.setLigneDebutMot(temp-1);
		sc.nextLine();
		
		System.out.println("saisir la colonne de la lettre du debut du mot");
		temp=sc.nextInt();
		this.setColonneDebutMot(temp-1);
		sc.nextLine();

	}
	
	public void changeFinMot(Scanner sc) {//permet de changer les coordonn�es de la fin du mot
		int temp;
		System.out.println("saisir la ligne de la lettre de fin du mot");
		temp=sc.nextInt();
		this.setLigneFinMot(temp-1);
		sc.nextLine();
		
		System.out.println("saisir la colonne de la lettre de fin du mot");
		temp=sc.nextInt();
		this.setColonneFinMot(temp-1);
		sc.nextLine();
	}
	
	public String WordSelection(){//permet de selectionner un mots de la grille
		Scanner sc= new Scanner(System.in);
		this.changeDebutMot(sc);
		this.changeFinMot(sc);
		String word="";
		if(this.getColonneDebutMot() == this.getColonneFinMot()) {//cas 1:mots est a la verticale
			
			if(this.getLigneDebutMot() <= this.getLigneFinMot()) {//cas 1.1:le mot est de haut en bas
				
				for(int compt = 0; compt < (this.getLigneFinMot() - this.getLigneDebutMot() + 1) ; compt++){
					word = word + (this.grille.getGrille() [(this.getLigneDebutMot() + compt)] [this.getColonneDebutMot() ]);
					//this.setWord(this.getWord()+(this.grille.getGrille() [(this.getLigneDebutMot() + compt)] [this.getColonneDebutMot() ]));
				}
				return word;
			}
			else {//cas 1.2:le mot est de bas en haut
				
				for(int compt = 0; compt < (this.getLigneDebutMot() - this.getLigneFinMot()  + 1) ; compt++){
					word = word + (this.grille.getGrille() [(this.getLigneDebutMot() - compt)] [this.getColonneDebutMot()]);
					//this.setWord(this.getWord() + (this.grille.getGrille() [(this.getLigneDebutMot() - compt)] [this.getColonneDebutMot()]));
				}
				return word;
			}
			 
		}
		else if(this.getLigneDebutMot() == this.getLigneFinMot()) {//cas 2:le mot est a l'horizontale
			
			if(this.getColonneDebutMot() <= this.getColonneFinMot()) {//cas 2.1:le mot est de gauche a droite
				
				for(int compt = 0; compt < (this.getColonneFinMot() - this.getColonneDebutMot() + 1) ; compt++){
					word = word + (this.grille.getGrille() [this.getLigneDebutMot()] [(this.getColonneDebutMot() + compt)]);
				}
				return word;
			}
			else {//cas 2.2:le mot est de droite a gauche
				
				for(int compt = 0; compt < (this.getColonneDebutMot() - this.getColonneFinMot() + 1) ; compt++){
					word = word + (this.grille.getGrille() [this.getLigneDebutMot()] [(this.getColonneDebutMot() - compt)]);
				}
				return word;
			}
		}
		else {//cas 3:on reset la selection
			System.out.println("Erreur,le mot ne peut pas etre en diagonale");
			
			this.setColonneDebutMot(0);
			this.setLigneDebutMot(0);
			
			this.setColonneFinMot(0);
			this.setLigneFinMot(0);
			
			return word;
		}
	}
}