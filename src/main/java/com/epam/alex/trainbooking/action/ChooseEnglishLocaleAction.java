package com.epam.alex.trainbooking.action;

        import com.epam.alex.trainbooking.exception.ActionException;
        import com.epam.alex.trainbooking.exception.LocaleChangerException;
        import com.epam.alex.trainbooking.util.LocaleUpdater;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
/**
 * Created by ${AlexandrSerebryakov} on ${09.10.2016}.
 */
public class ChooseEnglishLocaleAction implements Action {
    private static final String LOCALE_EN = "en";
    private static final String REFERRER = "referer";
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ActionException {

        LocaleUpdater changer = new LocaleUpdater();
        try {
            changer.changeUserLocale(req, LOCALE_EN);
        } catch (LocaleChangerException e) {
            throw new ActionException(e);
        }
        String referrer = req.getHeader(REFERRER);
        return REDIRECT_PREFIX + referrer;
    }


}


