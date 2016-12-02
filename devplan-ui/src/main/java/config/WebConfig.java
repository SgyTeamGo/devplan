package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by zaven.chilingaryan on 12/2/2016.
 */
@Configuration
@Import({UserConfig.class, EventConfig.class})
public class WebConfig {
}
