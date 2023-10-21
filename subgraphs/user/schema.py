import strawberry


@strawberry.type
class User:
    id: int
    name: str


users = [
    User(id=1, name=f"Unis Badri"),
    User(id=2, name=f"Namikaze Minato"),
]

@strawberry.type
class Query:
    @strawberry.field
    def users(self) -> list[User]:
        return users

    @strawberry.field
    def user(self, id: int) -> User | None:
        return next((r for r in users if r.id == id), None)


schema = strawberry.federation.Schema(
    query=Query,
    types=[User],
    enable_federation_2=True,
    extensions=[],
)