def script = new GroovyScriptEngine( '.' ).with {
    loadScriptByName( 'Main.groovy' )
}
this.metaClass.mixin script

// Domain Specific Language

/*
1. register name [name] username [username] email [email] password [password]
2. login username [username] password [password]
3. addfriend [username]
4. post status [content]
5. comment post [post id] content [content]
*/

register name "Jessica" username "jessicahandayani" email "asdasd" password "pass"