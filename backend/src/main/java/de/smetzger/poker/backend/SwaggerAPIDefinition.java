package de.smetzger.poker.backend;

import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import io.swagger.jaxrs.Reader;
import io.swagger.jaxrs.config.ReaderListener;
import io.swagger.models.Swagger;

//@formatter:off
@SwaggerDefinition(
      info = @Info(
              description = "This is a simple poker API.",
              version = "V1.0.0",
              title = "The Poker API"
      ),
      schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
      tags = {
              @Tag(name = "poker", description = "Default poker namespace")
      }
)
//@formatter:on

/**
 * This class provides the basic swagger api definition that applies to the
 * whole API.
 */
// strangely we have to annotate this class with some path and Api annotation
// for swagger to find it...probably a JAX-RS-Swagger issue

// there clearly is documentation Sonar just does not see it amidst all the tags
public class SwaggerAPIDefinition implements ReaderListener {
    public static final String BASIC_API_KEY_AUTHENTICATION = "BasicAccessAuthentication";

    @Override
    /** nothing do do as preparation */
    public void beforeScan(Reader reader, Swagger swagger) {
    }

    @Override
    public void afterScan(Reader arg0, Swagger arg1) {

    }

}
