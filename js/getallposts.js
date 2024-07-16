/** @format */

var postContainter = document.getElementById("posts_container");
var btn_pretrazi = document.getElementById("btn_pretrazi");
var text = document.getElementById("input_pretrazi");

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

function setPostId(postId) {
	localStorage.setItem("post_id", postId);
}

function givebuttonfunction() {
	const buttons = document.querySelectorAll(".view_btn");
	buttons.forEach((button) => {
		button.addEventListener("click", function (event) {
			const postId = button.getAttribute("data-id");

			setPostId(postId);
		});
	});
}

fetch("http://localhost:8082/posts")
	.then((response) => response.json())
	.then((posts) => {
		var postsMarkup = "";
		for (let post of posts) {
			postsMarkup += CardAdd(post);
		}
		postContainter.innerHTML = postsMarkup;
		givebuttonfunction();

		btn_pretrazi.addEventListener("click", function (event) {
			var postsMarkup = "";
			for (let post of posts) {
				if (post.title.toLowerCase().includes(text.value.toLowerCase()))
					postsMarkup += CardAdd(post);
			}
			postContainter.innerHTML = postsMarkup;
			givebuttonfunction();
		});
	});

document
	.getElementById("submitButton")
	.addEventListener("click", function (event) {
		event.preventDefault();

		const post = {
			id: document.getElementById("id").value,
			title: document.getElementById("title").value,
			owner: document.getElementById("owner").value,
			description: document.getElementById("description").value,
			picture: document.getElementById("picture").value,
		};

		fetch("http://localhost:8082/posts", {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(post),
		})
			.then((response) => response.json())
			.then((data) => {
				console.log("Success:", data);
				document
					.getElementById("submitSuccessMessage")
					.classList.remove("d-none");
			})
			.catch((error) => {
				console.error("Error:", error);
				document
					.getElementById("submitErrorMessage")
					.classList.remove("d-none");
			});
	});
