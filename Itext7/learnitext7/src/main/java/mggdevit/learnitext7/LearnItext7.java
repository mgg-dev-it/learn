package mggdevit.learnitext7;

public class LearnItext7 {

	public static void main(String[] args) {
		System.out.println("LearnItext7 start");
		new HelloWorld().createPDF(".\\LearnItext7-HelloWorld.pdf");
		new LearnItext7Font().createPDF(".\\LearnItext7-Font.pdf");
		System.out.println("LearnItext7 end");

	}

}
