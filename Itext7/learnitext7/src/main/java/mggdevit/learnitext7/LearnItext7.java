package mggdevit.learnitext7;

public class LearnItext7 {

	public static void main(String[] args) {
		System.out.println("LearnItext7 start");
		new LearnItext7HelloWorld().createPDF(".\\LearnItext7-HelloWorld.pdf");
		new LearnItext7Font().createPDF(".\\LearnItext7-Font.pdf");
		new LearnItext7List().createPDF(".\\LearnItext7-List.pdf");
		System.out.println("LearnItext7 end");

	}

}
