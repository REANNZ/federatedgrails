
/*
Specifies configuration to allow Shiro to interact with Shibboleth service provider
*/

federation {
  enabled = true
  automatelogin = false
  federationactive = false
  developmentactive = false
  autoprovision = false

  // Supported as fallback for problematic webservers but should usually be true
  // See https://wiki.shibboleth.net/confluence/display/SHIB2/NativeSPAttributeAccess for more
  request.attributes = true
  ssoendpoint = "/Shibboleth.sso/Login"

  // The subject class being utilized by the host application
  app.subject = "${pack}.${subject}"

  mapping {
    //
    principal = "persistent-id"   // The unique and persistent ID used to identify this principal for current and subsequent sessions (eduPersonTargetedID)
    credential = "Shib-Session-ID"  // The internal session key assigned to the session associated with the request and hence the credential used
    entityID = "Shib-Identity-Provider" // The entityID of the IdP that authenticated the user associated with the request.

    applicationID = "Shib-Application-ID" // The applicationId property derived for the request.
    idpAuthenticationInstant = "Shib-Authentication-Instant" // The ISO timestamp provided by the IdP indicating the time of authentication.

    /*
    See mappings in your attribute-map.xml file to enable more attributes (values for id)
    Some additional common requirements:
      displayName = "displayName"
      email= "mail"
      entitlement = "entitlement"
      homeOrganization = "homeOrganization"
      homeOrganizationType = "homeOrganizationType"
    */
  }
}
