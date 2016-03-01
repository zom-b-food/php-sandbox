<? include "/siteglobs/fragments/content-type-javascript.jspf" %>

<%--
- File Name: jsValidations.jsp
- Author(s):
- Copyright Notice:
- Description: Sets parameters in a javascript object for use in plugin scripts.
-    PLEASE NOTE: a lot of variables are set as jstl vars then output on page using c:out. We are
-    taking advantage of the escapeXML attribute (true by default) to escape values in these strings.
- Parameters:
-
--%>

<fmt:message var="errorheader" key="common.errorHeader"/>
<fmt:message var="ajaxError" key="common.errorAjax"/>

<%-- Session Length --%>
<c:set var="sessionTimeoutSecs" value="1800"/>

<%-- validation error messages --%>
<fmt:message var="errorEmail" key="error.email"/>
<fmt:message var="errorUspostal" key="error.uspostal"/>
<fmt:message var="errorCApostal" key="error.capostal"/>
<fmt:message var="errorUsOrCApostal" key="error.usorcapostal"/>
<fmt:message var="errorUsphone" key="error.usphone"/>
<fmt:message var="errorNumericNamed" key="error.numeric.named"/>
<fmt:message var="errorNumericUnnamed" key="error.numeric.unnamed"/>
<fmt:message var="errorCreditcard" key="error.creditcard"/>
<fmt:message var="errorRequiredNamed" key="error.required.named"/>
<fmt:message var="errorRequiredUnnamed" key="error.required.unnamed"/>
<fmt:message var="errorMinlengthNamed" key="error.minlength.named"/>
<fmt:message var="errorMinlengthUnnamed" key="error.minlength.unnamed"/>
<fmt:message var="errorMaxlengthNamed" key="error.maxlength.named"/>
<fmt:message var="errorMaxlengthUnnamed" key="error.maxlength.unnamed"/>
<fmt:message var="errorMatchPassword" key="error.matchPassword"/>
<fmt:message var="errorMatchEmail" key="error.matchEmail"/>
<fmt:message var="errorMatchEmail2" key="error.matchEmail2"/>
<fmt:message var="errorQty" key="error.qty"/>
<fmt:message var="errorPassword" key="error.password"/>
<fmt:message var="errorBirthdayDate" key="error.birthday.date"/>
<fmt:message var="errorBirthdayAge" key="error.birthday.age"/>
<fmt:message var="errorGiftMessage" key="error.gift.message"/>
<fmt:message var="maxPromotionsReached" key="cart.maxPromotionsReached"/>

(function (global, namespace ) {
"use strict";

var constants = {
contextPath : '${contextPath}',
sessionTimeoutMillis : 1000 * <c:out value="${sessionTimeoutSecs}"/>,

/* lang */
errorheader : '<c:out value="${errorheader}"/>',
ajaxError : '<c:out value="${ajaxError}"/>' ,

messages : {
email : '<c:out value="${errorEmail}"/>',
uspostal : '<c:out value="${errorUspostal}"/>',
capostal : '<c:out value="${errorCApostal}"/>',
usorcapostal : '<c:out value="${errorUsOrCApostal}"/>',
usphone : '<c:out value="${errorUsphone}"/>',
numeric : {
named : '<c:out value="${errorNumericNamed}"/>',
unnamed : '<c:out value="${errorNumericUnnamed}"/>'
},
creditcard : '<c:out value="${errorCreditcard}"/>',
required : {
named : '<c:out value="${errorRequiredNamed}"/>',
unnamed : '<c:out value="${errorRequiredUnnamed}"/>'
},
minlength : {
named : '<c:out value="${errorMinlengthNamed}"/>',
unnamed : '<c:out value="${errorMinlengthUnnamed}"/>'
},
maxlength : {
named : '<c:out value="${errorMaxlengthNamed}"/>',
unnamed : '<c:out value="${errorMaxlengthUnnamed}"/>'
},
matchPassword : '<c:out value="${errorMatchPassword}"/>',
matchEmail : '<c:out value="${errorMatchEmail}"/>',
matchEmail2 : '<c:out value="${errorMatchEmail2}"/>',
qty : '<c:out value="${errorQty}"/>',
password : '<c:out value="${errorPassword}"/>',
dateOfBirthDate : '<c:out value="${errorBirthdayDate}"/>',
dateOfBirthAge : '<c:out value="${errorBirthdayAge}"/>',
invalidGiftMessage : '<c:out value="${errorGiftMessage}"/>',
maxPromotionsReached: '<c:out value="${maxPromotionsReached}"/>'
}
};

if (!global[namespace]) {
global[namespace] = {};
}
global[namespace].constants = constants;

}(this, "KP"));