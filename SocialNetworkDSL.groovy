class SocialNetworkDSL {

    def dbConnector

    def comment(post) {
        [from: { who ->
            [content: { content -> 
                def user = dbConnector.getUser(who)
            }]
        }]
    }

    // Register method
    def register(username) {
        [password: { password ->
            [email: { email -> 
                [name: { name -> 
                    [biodata: { my_biodata ->
                        [sex: { sex ->
                            [location: { location ->
                                [dateofbirth: { dateofbirth ->
                                    def date = Date.parse('M-d-yyyy', dateofbirth)
                                    def profile = new Profile(name, biodata, date, sex, location)
                                    def user = new User(1, username, password, email, profile)
                                    
                                    def id = dbConnector.addUser(user)
                                    return id   // return > 0 if adding is successful, 0 if existing, -1 if database error
                                }]
                            }]
                        }]
                    }]
                }]
            }]
        }]
    }

    def login(username) {
        [password: { password -> 
            def result = dbConnector.getUserCredentials(username, password)
            if (result == 1) {
                return true
            } else {
                return false
            }
        }]
    }
    
    def post(content) {
        [by : { who -> 
            [privacy : { privacy -> 
                def createTime = new Date().format("yyyy-MM-dd hh:mm:ss")
                def updateTime = createTime
                def user = dbConnector.getUser(who)
                def post = new Post(1, content, createTime, updateTime, user, privacy)

                def result = dbConnector.addPost(post)
                return result   // return > 0 if adding is successful, 0 if existing, -1 if database error
            }]
        }]
    }

}
