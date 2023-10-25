package in.vff.exception;

public class TouristNotFoundException extends RuntimeException {

	private static final long serialVersionUID=1l;
	
	
	public TouristNotFoundException(String message) {
		super(message);
	}
	
}
