package socialnetwork

def script = new GroovyScriptEngine( '.' ).with {
    loadScriptByName( 'Controller.groovy' )
}
this.metaClass.mixin script

// Domain Specific Language

/*
1. register [name] username [username] email [email] password [password]
2. login [username] password [password]
3. addfriend [username]
4. post [content]
5. comment [post id] content [content]
*/

/*register "Jessica" password "pass" email "jessica@mail.com" description "jessica" sex "Perempuan" location "Bandung" dateofbirth "21-02-1995"
*/
login "" password "pass"
addfriend "try"
post "halo namaku jessica"
comment 1 content "hai jessica"
