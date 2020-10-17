package res;

import java.net.URL;

public final class Assets {
	
	public final URL STYLESHEETS_CSS;
	
	public Assets() {
		STYLESHEETS_CSS = this.getClass().getResource("stylesheets.css");
	}
}
