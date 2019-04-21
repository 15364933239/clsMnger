package core.support;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 
 * @author zhangsheng
 * 2019-02-26 16:32:19
 * <dl>
 * 		<dt>DateSerializer</dt>
 *		<dd></dd>
 * </dl>
 */
public class DateSerializer extends JsonSerializer<Date> {

	private static final String DATE_FORMAT = "yyyy-MM-dd";

	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		jgen.writeString(DateFormatUtils.format(value, DATE_FORMAT));
	}

}
