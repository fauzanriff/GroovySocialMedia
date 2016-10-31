package socialnetwork

class Controller {
    def register(name){
	
		[username: {username ->
			[email: {email ->
				[password: {password ->
                                        def user = new User(1, username);
					println("You've registered!");
                                        
				}]
			}]
		}]
			
    }

    def login(){
	[username: {username ->
		[password: {password ->
			//panggil fungsi
			
		
		}]
	}]		
    }

    def addfriend(username){
	
    }

    def post(){
	[status: {status ->
                
        }]
    }
    
    def comment(){
        [post: {postid ->
                [content: {content ->
                        
                }]
        }]
    }
  
     
}


