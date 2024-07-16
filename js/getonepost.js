/** @format */

var postContainter = document.getElementById("posts_container");
console.log(postContainter);
function CardAdd(post) {
	return `   
            <!-- Header-->
            <header class="bg-dark py-5">
                <div class="container px-5">
                    <div class="row gx-5 align-items-center justify-content-center">
                        <div class="col-lg-8 col-xl-7 col-xxl-6">
                            <div class="my-5 text-center text-xl-start">
                                <h1 class="display-5 fw-bolder text-white mb-2">${
																	post.title
																}</h1>
                                <p class="lead fw-normal text-white-50 mb-4">${
																	post.description
																}</p>

                            </div>
                        </div>
                        <div class="col-xl-5 col-xxl-6 d-none d-xl-block text-center"><img class="img-fluid rounded-3 my-5 img-customm" src="/assets/${
													post.picture
												}" alt="..." /></div>
                    </div>
                </div>
            </header>
<section class="py-5 bg-light">
                <div class="container px-5 my-5">
                    <div class="text-center">
                        <h2 class="fw-bolder">User</h2>
                        <p class="lead fw-normal text-muted mb-5">Owned by</p>
                    </div>
                    <div class="row gx-5 row-cols-1 row-cols-sm-2 row-cols-xl-4 justify-content-center">
                        <div class="col mb-5 mb-5 mb-xl-0">
                            <div class="text-center">
                                <img class="img-fluid rounded-circle mb-4 px-4" src="https://dummyimage.com/150x150/ced4da/6c757d" alt="..." />
                                <h5 class="fw-bolder">${
																	post.ownerFirstname + " " + post.ownerLastname
																}</h5>
                                <div class="fst-italic text-muted">${
																	"Godine: " + post.ownerYears
																}</div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

			`;
}

localStorage.getItem("post_id");

fetch(`http://localhost:8082/posts/withuser/${localStorage.getItem("post_id")}`)
	.then((response) => response.json())
	.then((post) => {
		postContainter.innerHTML = CardAdd(post);
	});
document.getElementById("dl").addEventListener("click", function (event) {
	event.preventDefault();

	const postId = localStorage.getItem("post_id");

	fetch(`http://localhost:8082/posts/${postId}`, {
		method: "DELETE",
	})
		.then((response) => {
			window.location.href = "/posts.html"; // Change this to your desired URL
		})
		.catch((error) => {
			console.error("Error:", error);
			document.getElementById("deleteErrorMessage").classList.remove("d-none");
		});
});

document
	.getElementById("updateForm")
	.addEventListener("submit", function (event) {
		event.preventDefault();
		const postId = localStorage.getItem("post_id");
		const title = document.getElementById("title").value;
		const description = document.getElementById("description").value;
		const picture = document.getElementById("picture").value;

		const postData = {
			title: title,
			description: description,
			picture: picture,
		};

		fetch(`http://localhost:8082/posts/${postId}`, {
			method: "PUT",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(postData),
		})
			.then((response) => {
				if (!response.ok) {
					throw new Error("Network response was not ok " + response.statusText);
				}
				return response.json();
			})
			.then((data) => {
				console.log("Post updated successfully:", data);
				alert("Post updated successfully!");
			})
			.catch((error) => {
				console.error("Error:", error);
				document
					.getElementById("updateErrorMessage")
					.classList.remove("d-none");
			});
	});
