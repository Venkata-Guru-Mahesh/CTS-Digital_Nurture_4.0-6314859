import React from 'react';
import Post from './Post';
import axios from 'axios';

class Posts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError:false
    };
  }

  loadPosts() {
    axios.get('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        const postList = response.data.map(p => new Post(p.id, p.title, p.body));
        this.setState({ posts: postList });
      })
      .catch(error => {
        this.setState({hasError:true});
        console.error("Error while fetching posts url : ",error);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  render() {

    if(this.state.hasError){
       return <h3>Error while fetching Posts url</h3>;
    }

    return (
      <div>
        <h1>Posts</h1>
        {this.state.posts.map(post => (
          <div key={post.id}>
            <h3>Post Id-{post.id} :  {post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }

  componentDidCatch(error, info) {
    alert('Error while rendering components');
    console.error('Caught error:', error,info);
  }
}

export default Posts;
