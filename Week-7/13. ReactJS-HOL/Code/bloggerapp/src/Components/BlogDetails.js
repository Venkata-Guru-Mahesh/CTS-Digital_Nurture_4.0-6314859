export const blogContent =[ 
    {title:'React Learning',author:'Stephen Biz',description:'Welcome to learning React!'},
    {title:'Installation',author:'Schwarzdenier',description:'You can install React from npm.'}];

const BlogDetails=(props)=>{
  const content =(
    <ul>
    <div>
      {props.content.map((blog)=>(
        <div key={blog.title}>
          <h2>{blog.title}</h2>
          <h4>{blog.author}</h4>
          <p>{blog.description}</p>
        </div>
      ))}
    </div>
    </ul>
  ) 
  
return content;
};

export default BlogDetails;