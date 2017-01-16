
import domain.UserPOJO;
import domain.AddressPOJO;
import java.util.Date;
import java.util.HashMap;
import org.apache.wicket.markup.html.TemplateMarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		HashMap myMap = new HashMap();
		myMap.put("name", "Name");
		myMap.put("lastname", "Lastname");

		UserPOJO user = newUser();
		add(new TemplateMarkupContainer("mapContent", Model.ofMap(myMap)));

		add(new TemplateMarkupContainer("pojoContent", Model.of(user)) {
			@Override
			protected String onValue(String expression, Object value) {
				if (expression.equals("name")) {
					return "Modified: " + super.onValue(expression, value);
				}
				else {
					return super.onValue(expression, value);
				}
			}
		});
	}

	private UserPOJO newUser() {
		return new UserPOJO("Name", "Lasname", new Date(), new AddressPOJO("St27", "980"));
	}

}
