class SocialNetwork {

    def dbConnector

    def comment(post) {
        [from: { who ->
            [content: { content -> 
                def user = dbConnector.getUserFromId(who)
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

}
