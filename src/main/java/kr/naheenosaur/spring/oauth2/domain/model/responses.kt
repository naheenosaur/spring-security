package kr.naheenosaur.spring.oauth2.domain.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class TokenData @JsonCreator constructor(
        @param:JsonProperty("access_token")
        @get:JsonProperty("access_token")
        val accessToken: String?,

        @param:JsonProperty("expires_in")
        @get:JsonProperty("expires_in")
        val expiresIn: String?,

        @param:JsonProperty("scope")
        @get:JsonProperty("scope") val scope: String?,

        @param:JsonProperty("employee_info")
        @get:JsonProperty("employee_info")
        val employeeInfo: EmployeeInfo?
)

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class EmployeeInfo @JsonCreator constructor(
        @param:JsonProperty("company_id")
        @get:JsonProperty("company_id")
        val companyId: String?,

        @param:JsonProperty("employee_id")
        @get:JsonProperty("employee_id")
        val employeeId: String?
)
