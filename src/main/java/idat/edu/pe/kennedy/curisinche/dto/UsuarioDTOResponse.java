package idat.edu.pe.kennedy.curisinche.dto;

public class UsuarioDTOResponse {
	private String token;

	public UsuarioDTOResponse() {
	}

	public UsuarioDTOResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
