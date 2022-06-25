<<<<<<< Upstream, based on branch 'development' of https://github.com/sigala1990/Proyecto_API_BootCamp22.git
package es.http.service.security;

public class Constants {

	// Spring Security

	public static final String LOGIN_URL = System.getenv().get("LOGIN_URL");
	public static final String HEADER_AUTHORIZACION_KEY = System.getenv().get("HEADER_AUTHORIZACION_KEY");
	public static final String TOKEN_BEARER_PREFIX = System.getenv().get("TOKEN_BEARER_PREFIX");

	// JWT

	public static final String ISSUER_INFO = System.getenv().get("ISSUER_INFO");
	public static final String SUPER_SECRET_KEY = System.getenv().get("SUPER_SECRET_KEY");
	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day
	
	// Swagger
	
	public static final String SWAGGER_RESOURCES = System.getenv().get("SWAGGER_RESOURCES");
	public static final String SWAGGER_UI_HTML = System.getenv().get("SWAGGER_UI_HTML");
	public static final String SWAGGER_API_DOCS = System.getenv().get("SWAGGER_API_DOCS");
	public static final String SWAGGER_UI = System.getenv().get("SWAGGER_UI");
	public static final String SWAGGER_WEBJARS = System.getenv().get("SWAGGER_WEBJARS");

=======
package es.http.service.security;

public class Constants {

	// Spring Security

	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT

	public static final String ISSUER_INFO = "Jose MarÃ­n";
	public static final String SUPER_SECRET_KEY = "1234";
	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day
	
	// Swagger
	
	public static final String SWAGGER_RESOURCES = "/swagger-resources/**";
	public static final String SWAGGER_UI_HTML = "/swagger-ui.html";
	public static final String SWAGGER_API_DOCS = "/v3/api-docs";
	public static final String SWAGGER_UI = "/swagger-ui/**";
	public static final String SWAGGER_WEBJARS = "/webjars/**";

>>>>>>> f7585f1 Fix error
}