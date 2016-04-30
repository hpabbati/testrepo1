package helloWorldPackage;

import edu.duke.*;

public class TagFinder {
	public static void main(String[] args) {
		String dna = "GCCGTAGTAACGTCCTGTAG";
		TagFinder myTag = new TagFinder();
		String[] myProtein = myTag.findProtein(dna);
		/*if(myProtein == ""){
			System.out.println("No Protein");
		}*/
			
		System.out.println(myProtein[0]);
	}
	
	
	
	
	
	
	public String[] findProtein(String dna){
		String startCodon = "AGT";
		String[] stopCodons = {"TAG", "TGA", "TAA"};
		int startPos=0;
		int stopPos=0;
		String proteins[] = new String[10];
		int index=0;
		while(true)
		{
			startPos = dna.indexOf(startCodon);
			if(startPos == -1){
				break;
			}
			else{
				for(String stopCodon : stopCodons){
					int test = 0;
					stopPos = dna.indexOf(stopCodon, startPos+3 );
					String protein = dna.substring(startPos, stopPos+3);
					if (protein != ""){
						if (protein.length() % 3 == 0){
							proteins[index]=protein;
							test = 1;
						}
					}
					if(test ==1){
						break;
					}
					startPos = stopPos+4;
					
				}
			}
			return proteins;
		}
		proteins[index]="";
		return proteins;
	}
	
	
}
