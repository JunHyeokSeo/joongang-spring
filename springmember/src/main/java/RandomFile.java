import java.util.UUID;

public class RandomFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = "clock.jpg";
		//확장자
		String extension = filename.substring(filename.lastIndexOf("."), filename.length());
		System.out.println("extension:"+extension);

		//uuid
		UUID uuid = UUID.randomUUID();
		System.out.println("uuid:"+uuid);

		//uuid + 확장자
		String newfilename = uuid.toString() + extension;
		System.out.println("newfilename:"+newfilename);
		
	}

}
