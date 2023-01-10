import React, { useEffect, useState } from "react";
import Blog from "./Blog";
import { BASE_URL } from "../config";
import "./post.css";

const Post = () => {

    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () =>{
            try {
                const response = await fetch(`${BASE_URL}/posts`);
                const jsonData = await response.json();
                setData(jsonData);
            } catch (error) {
                console.error(error);
            }
        };

        fetchData();

    }, []);
   

    return (
        <div>

            {
               data.posts && data.posts.map(post => <Blog key={post.id} post={post}/>)
            }

            
        </div>
    );
};

export default Post;