'use strict';

const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');
const csrfHeader = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');

axios.defaults.headers.common[csrfHeader] = csrfToken;

const { useState, useEffect } = React;
const { HashRouter, Route, withRouter } = ReactRouterDOM;

const Home = withRouter(({ history, location }) => {
    const [posts, setPosts] = useState([]);
    const [cats, setCats] = useState([]);
    const [cities, setCities] = useState([]);
    const [postsCount, setPostsCount] = useState(posts.length);
    const [order, setOrder] = useState('評価順');

    const [defaultParam, setDefaultParam]=useState({
        category: '',
        keyword: '',
        region: document.getElementById("region").value
    });

    const [defLoad, setDefLoad] = useState(false);
    console.log(defaultParam.region);
    console.log(defLoad);

    const [searchParams, setSearchParams] = useState({
        category: '',
        keyword: '',
        region: ''
    });
    const [showResults, setShowResults] = useState(false);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        const params = new URLSearchParams(location.search);
        setSearchParams({
            category: params.get('category') || '',
            keyword: params.get('keyword') || '',
            region: params.get('region') || ''
        });
        setShowResults(location.search !== '');

    }, [location.search, order]);

    const handleInputChange = (e) => {

        const { name, value } = e.target;
        setSearchParams(prev => ({ ...prev, [name]: value }));

    };

    const likeClick = (e) => {
        console.log("like");

    };

    const handleOrderChange = (event) => {
        setOrder(event.target.value);
    };

    useEffect(() => {
        let { category, keyword, region } = defaultParam;
        if(defLoad){
            category=searchParams.category;
            keyword=searchParams.keyword;
            region=searchParams.region;
        }
        /*
        else{
            const { category, keyword, region } = defaultParam;
            setDefLoad(false);
        }
        */

        history.push(`/?category=${category}&keyword=${keyword}&region=${region}&order=${order}`);
        setShowResults(true);
        const fetchPosts = async () => {
            try {
                let url = '/api/search';
                if (order === '新しい順') {
                    url = '/api/search/updatedAt/Desc';
                } else if (order === '古い順') {
                    url = '/api/search/updatedAt/Asc';
                }
                const response = await axios.get(url, {
                    params: {
                        category,
                        keyword,
                        region
                    }
                });
                setPosts(response.data);
            } catch (error) {
                console.error('Error fetching posts:', error);
            }
        };
        fetchPosts();
        setDefLoad(true);
    }, [searchParams, showResults, order]);

    useEffect(() => {
        const fetchCategories = async () => {
            const response = await axios.get('/api/search/categories');
            setCats(response.data);
        };
        fetchCategories();
    }, []);

    useEffect(() => {
        const fetchCities = async () => {
            const response = await axios.get('/api/search/cities');
            setCities(response.data);
        };
        fetchCities();
    }, []);

    useEffect(() => {
        setPostsCount(posts.length);
     }, [posts]);

    return (
        <div>
            <div>
                <select
                    name="category"
                    value={searchParams.category}
                    onChange={handleInputChange}
                >
                    <option value="">全部</option>
                    {cats.map(cat => (
                        <option key={cat.id} value={cat.name}>{cat.name}</option>
                    ))}
                </select>
                <input
                    type="text"
                    name="keyword"
                    value={searchParams.keyword}
                    onChange={handleInputChange}
                    placeholder="キーワード"
                />
                <select
                    name="region"
                    value={searchParams.region}
                    onChange={handleInputChange}
                >

                    {cities.map(city => (
                        <option key={city.id} value={city.name}>{city.name}</option>
                    ))}
                </select>
                <p>
                    検索結果：<span id="postsCount">{postsCount}</span>件　
                    並び替え：
                    <select value={order} onChange={handleOrderChange}>
                        <option value="評価順">評価順</option>
                        <option value="新しい順">新しい順</option>
                        <option value="古い順">古い順</option>
                    </select>
                </p>
            </div>
            <div>
                {posts.map(post => (
                    <Post key={post.id} post={post} />
                ))}
            </div>
        </div>
    );
});

const Post = ({ post }) => {
    const [liked, setLiked] = useState(false);
    const [bookmarked, setBookmarked] = useState(false);
    const [getBookmark, setGetBookmark] = useState([]);
    const [getLike, setGetLike] = useState([]);
    const [likeCount, setLikeCount] = useState([]);

    useEffect(() => {
        const fetchGetBookmark = async () => {
            const response = await axios.get(`/api/bookmarks`);
            setGetBookmark(response.data);
        };
        fetchGetBookmark();

    }, []);

    useEffect(() => {
        const fetchCities = async () => {
            const response = await axios.get(`/api/likes/count/${post.id}`);
            setLikeCount(response.data);
        };
        fetchCities();
    }, [liked, setLiked]);

    const likeClick = async () => {
        try {
            if (liked) {
                await axios.post(`/api/likes/delete/${post.id}`);
            } else {
                await axios.post(`/api/likes/${post.id}`);
            }
        } catch (error) {
            console.error("Error", error);
        }
        setLiked(!liked);
    };

    const bookmarkClick = async () => {
        setBookmarked(!bookmarked);
        try {
            if (bookmarked) {
                await axios.post(`/api/bookmarks/delete/${post.id}`);
            } else {
                await axios.post(`/api/bookmarks/${post.id}`);
            }
        } catch (error) {
            console.error("Error", error);
        }
    };

    const bookmarkCheck = getBookmark.map((bookmark) => {
      return `{bookmark.id}`;
    });

    console.log(bookmarkCheck);

    return (
        <div className="posts">
            <div className="post">
                <img className="image" src={post.imageFile1} alt="post" />
                <div className="information">
                    <div className="box-top">
                        <h1 className="title"><a href={"/posts/detail/" + post.id}>{post.title}</a></h1>
                        <div className="category-box">
                            <span>{post.users.username}</span>
                        </div>
                    </div>
                    <div className="box-center">
                        <span className="summary">{post.summary}</span>
                    </div>
                    <div className="box-bottom">
                        <span className="city">{post.cities.name}/</span>
                        <span className="category">{post.categories.name}</span>
                        <div className="like">
                            <input
                                className="click-img"
                                type="image"
                                onClick={likeClick}
                                src={liked ? '../img/like-after.png' : '../img/like-before.png'}
                            /><span>{likeCount}</span>

                            <input
                                className="click-img"
                                type="image"
                                onClick={bookmarkClick}
                                src={bookmarked ? '../img/bookmark-after.png' : '../img/bookmark-before.png'}
                            />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

const App = () => {
    return (
        <HashRouter>
            <Route path="/" component={Home} />
        </HashRouter>
    );
};
ReactDOM.render(<App />, document.getElementById('root'));