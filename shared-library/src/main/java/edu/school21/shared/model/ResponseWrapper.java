package edu.school21.shared.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.jetbrains.annotations.Nullable;

@Value
public class ResponseWrapper<T> {

	/** Body */
	@Nullable
	T body;
	/** Http status */
	Integer status;
	/** Error message if error has occurred */
	@Nullable
	String error;

	@JsonCreator
	public ResponseWrapper(@JsonProperty("body") @Nullable T body,
						   @JsonProperty("status") Integer status,
						   @JsonProperty("error") @Nullable String error) {
		this.body = body;
		this.status = status;
		this.error = error;
	}

}
