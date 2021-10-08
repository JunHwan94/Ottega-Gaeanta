db.createUser(
        {
            user: "root",
            pwd: "b4a1",
            roles: [
                {
                    role: "readWrite",
                    db: "styles"
                }
            ]
        }
);