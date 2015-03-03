package controllers;

import models.Post;
import play.*;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


public class PostController extends Controller {

	public static Result create() {
		Form<Post> postForm = new Form<Post>(Post.class).bindFromRequest();

		if (postForm.hasErrors()) {
			return ok(showUser.render(Session.getCurrentUser(ctx()), postForm));
		}
		Post newPost = postForm.get();
		Post.create(newPost.content, Session.getCurrentUser(ctx()));
		return redirect("/user/" + Session.getCurrentUser(ctx()).id);
	}
}
