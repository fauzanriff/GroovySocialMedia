package socialnetwork

class Controller {
    def sn = new SocialNetwork();
    def currentUser;
    
    def register(name){
	
		[username: {username ->
			[email: {email ->
				[password: {password ->
                                        sn.register(name, username, email, password);
                                        println ("Welcome, $name!");
                                        
				}]
			}]
		}]
			
    }

    def login(username){
	
		[password: {password ->
			println sn.login(username, password);
			println ("Hello, $username");
		
		}]
			
    }

    def addfriend(username){
	//currentUser.addFriend("username");
        
    }

    def post(status){
	//
    }
    
    def comment(postid){
        
                [content: {content ->
                        
                }]
        
    }
  
     
}


