
public class TestAuthor {

	public static void main(String[] args) {
		//Author class tester
		Author auth = new Author("Author", "Email", "m".charAt(0));
		//print email test
		//Testing the functionality of the object
		System.out.println(auth.getEmail());
		System.out.println(auth.getGender());
		System.out.println(auth.getName());
	}

}
