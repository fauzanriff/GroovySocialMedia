def script = new GroovyScriptEngine( '.' ).with {
    loadScriptByName( 'Controller.groovy' )
}
this.metaClass.mixin script

// Domain Specific Language

/*
1. register [name] username [username] password [password] email [email] sex [sex] location [location] dateofbirth [dateofbirth]
2. login [username] password [password]
3. addfriend [username]
4. post [content]
5. comment [post id] content [content]
*/

register "Jessica" password "pass" email "jessica@mail.com" name "kuda" profil "halo" sex "perempuan" location "Bandung" dateofbirth "15-03-1995"
login "Jessica" password "pass"
addfriend "try" to "Jessica"
post "halo namaku jessica" by "Jessica" privacy "public"
//comment 1 content "hai jessica"
