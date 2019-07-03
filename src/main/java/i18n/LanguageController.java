package i18n;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author nkengasong
 */
@Named
@SessionScoped
public class LanguageController implements Serializable {
    
    private String locale = "en";

    public LanguageController() {
        
    }

    public String english() {
        locale = "en";
        return FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo() + "?faces-redirect=true";
    }

    public String french() {
        locale = "fr";
        return FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo() + "?faces-redirect=true";
    }
    
    public String chinese() {
        locale = "zh";
        return FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo() + "?faces-redirect=true";
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
    
}
