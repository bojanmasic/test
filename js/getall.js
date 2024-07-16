/** @format */

var postContainter = document.getElementById("posts_container");
var userContainter = document.getElementById("users_container");

function CardAdd(post) {
	return `                    
        <div class="col mb-5">
                        <div class="card h-100" >
                            <!-- Product image-->
                            <img class="card-img-top img-custom card_img" src='..//assets/${post.picture}'  alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4 ">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder post_title">${post.title}</h5>
                                    <!-- Product price-->
                                    <p class="post_description">${post.description}</p>
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent ">
                                <div data-id="${post.id}" class="text-center view_btn" ><a class="btn btn-outline-dark mt-auto" href="post.html">View</a></div>
                            </div>
                        </div>
                    </div>`;
}
function UserCardAdd(post) {
	return `                    
        <section class="py-5 bg-light">
                    <div class="row gx-5  justify-content-center">
                        
                            <div class="text-center">
                                <img class="img-fluid rounded-circle mb-4 px-4" src="/assets/${
																	post.ownerPicture
																}" alt="..." />
                                <h5 class="fw-bolder">${
																	post.ownerFirstname + " " + post.ownerLastname
																}</h5>
                                <div class="fst-italic text-muted">${
																	"Godine: " + post.ownerYears
																}</div>
                            </div>
                        </div>
                    
                </div>
            </section>`;
}

function setPostId(postId) {
	localStorage.setItem("post_id", postId);
}

fetch("http://localhost:8082/posts/allwithusers")
	.then((response) => response.json())
	.then((posts) => {
		var postsMarkup = "";
		for (let post of posts) {
			postsMarkup += CardAdd(post);
		}
		postContainter.innerHTML = postsMarkup;

		var usersMarkup = "";
		var postcon = [];
		for (let post of posts) {
			if (!postcon.includes(post.ownerId)) {
				postcon.push(post.ownerId);
				usersMarkup += UserCardAdd(post);
			}
		}
		userContainter.innerHTML = usersMarkup;

		const buttons = document.querySelectorAll(".view_btn");
		buttons.forEach((button) => {
			button.addEventListener("click", function (event) {
				const postId = button.getAttribute("data-id");
				console.log(postId);

				setPostId(postId);
			});
		});
	});
