package com.bfxy.rabbit.common.convert;

import com.bfxy.rabbit.common.serializer.Serializer;
import com.google.common.base.Preconditions;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

/**
 * 	$GenericMessageConverter
 * @author Alienware
 *
 */
public class GenericMessageConverter implements MessageConverter {
	
	private Serializer serializer;

	public GenericMessageConverter(Serializer serializer) {
		Preconditions.checkNotNull(serializer);
		this.serializer = serializer;
	}

    /**
     * org.springframework.amqp.core.Message转换为com.bfxy.rabbit.api.Message
     * @param message
     * @return
     * @throws MessageConversionException
     */
	@Override
	public Object fromMessage(org.springframework.amqp.core.Message message) throws MessageConversionException {
		return this.serializer.deserialize(message.getBody());
	}

    /**
     * com.bfxy.rabbit.api.Message转化为org.springframework.amqp.core.Message
     * @param object
     * @param messageProperties
     * @return
     * @throws MessageConversionException
     */
	@Override
	public org.springframework.amqp.core.Message toMessage(Object object, MessageProperties messageProperties)
			throws MessageConversionException {
		return new org.springframework.amqp.core.Message(this.serializer.serializeRaw(object), messageProperties);
	}

}
