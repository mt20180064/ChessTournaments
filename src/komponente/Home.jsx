import React from 'react'
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


const Home = () => {

  return (

    <div className="container">
    <div className="pozadina" style={{backgroundImage:'url("https://w0.peakpx.com/wallpaper/975/363/HD-wallpaper-redden-chess-3d-art-red-black-abstract-chess.jpg")'}}>
     
     <div className="container mt-5">
            <div className="row">
                <div className="col-lg-8">
                   
                    <article>
                        
                        <header className="mb-4">
                            
                            <h1 className="fw-bolder mb-1">Dobrodošli na naš blog!</h1>
                            
                            <div className="text-muted fst-italic mb-2">Posted on January 1, 2023 by OnlineUčionica</div>
                           
                            <a className="badge bg-secondary text-decoration-none link-light" href="#!">sponsori</a>
                            <a className="badge bg-secondary text-decoration-none link-light" href="#!">saradnici</a>
                        </header>
                       
                        <figure className="mb-4"><img className="img-fluid rounded" src="https://thumbs.dreamstime.com/z/online-education-online-learning-learn-to-think-flat-icons-yellow-background-vector-illustration-cool-screen-data-hat-98156779.jpg" alt="..." /></figure>
                        
                        <section className="mb-5">
                            <p className="fs-5 mb-4">Science is an enterprise that should be cherished as an activity of the free human mind. Because it transforms who we are, how we live, and it gives us an understanding of our place in the universe.</p>
                            <p className="fs-5 mb-4">The universe is large and old, and the ingredients for life as we know it are everywhere, so there's no reason to think that Earth would be unique in that regard. Whether of not the life became intelligent is a different question, and we'll see if we find that.</p>
                            <p className="fs-5 mb-4">If you get asteroids about a kilometer in size, those are large enough and carry enough energy into our system to disrupt transportation, communication, the food chains, and that can be a really bad day on Earth.</p>
                            <h2 className="fw-bolder mb-4 mt-5">Aktuelni trend - online (l)earning!</h2>
                            <p className="fs-5 mb-4">For me, the most fascinating interface is Twitter. I have odd cosmic thoughts every day and I realized I could hold them to myself or share them with people who might be interested.</p>
                            <p className="fs-5 mb-4">Venus has a runaway greenhouse effect. I kind of want to know what happened there because we're twirling knobs here on Earth without knowing the consequences of it. Mars once had running water. It's bone dry today. Something bad happened there as well.</p>
                        </section>
                    </article>
                    
                    <section className="mb-5">
                        <div className="card bg-light">
                            <div className="card-body">
                                
                                <form className="mb-4"><textarea className="form-control" rows="3" placeholder="Pridružite se diskusiji i ostavite svoj komentar!"></textarea></form>
                               
                                <div className="d-flex mb-4">
                                    
                                    <div className="flex-shrink-0"><img className="rounded-circle" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQh7RFJE8V-WCVVwFGh1clQzqZWUmlY9qSIBA&usqp=CAU" alt="..." /></div>
                                    <div className="ms-3">
                                        <div className="fw-bold">Dr.Viktor Mihajlović</div>
                                        If you're going to lead a space frontier, it has to be government; it'll never be private enterprise. Because the space frontier is dangerous, and it's expensive, and it has unquantified risks.
                                        
                                        <div className="d-flex mt-4">
                                            <div className="flex-shrink-0"><img className="rounded-circle" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTW-3IxLK3kaJ1ZfedrVoFE2_ph35In0NFDNA&usqp=CAU" alt="..." /></div>
                                            <div className="ms-3">
                                                <div className="fw-bold">snasneRole</div>
                                                And under those conditions, you cannot establish a capital-market evaluation of that enterprise. You can't get investors.
                                            </div>
                                        </div>
                                        
                                        <div className="d-flex mt-4">
                                            <div className="flex-shrink-0"><img className="rounded-circle" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwZt4kUwr-IeHljK0v-brP-OqQlrQbHPYdvLOkA3ra1AHwa6dbxkUzctQ_lqnJxLbzI_s&usqp=CAU" alt="..." /></div>
                                            <div className="ms-3">
                                                <div className="fw-bold">mackatron</div>
                                                When you put money directly to a problem, it makes a good headline.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                                <div className="d-flex">
                                    <div className="flex-shrink-0"><img className="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div>
                                    <div className="ms-3">
                                        <div className="fw-bold">Gost</div>
                                        When I look at the universe and all the ways the universe wants to kill us, I find it hard to reconcile that with statements of beneficence.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
                
                <div className="col-lg-4">
                    
                    <div className="card mb-4">
                        <div className="card-header">Pretraži</div>
                        <div className="card-body">
                            <div className="input-group">
                                <input className="form-control" type="text" placeholder="Ukucajte parametre za pretragu..." aria-label="Enter search term..." aria-describedby="button-search" />
                                <button className="btn btn-primary" id="button-search" type="button">Traži</button>
                            </div>
                        </div>
                    </div>
                    
                    <div className="card mb-4">
                        <div className="card-header">Kategorije tekstova</div>
                        <div className="card-body">
                            <div className="row">
                                <div className="col-sm-6">
                                    <ul className="list-unstyled mb-0">
                                        <li><a href="#!">Matematika</a></li>
                                        <li><a href="#!">Hemija</a></li>
                                        <li><a href="#!">Fizika</a></li>
                                    </ul>
                                </div>
                                <div className="col-sm-6">
                                    <ul className="list-unstyled mb-0">
                                        <li><a href="#!">Filozofija</a></li>
                                        <li><a href="#!">Sociologija</a></li>
                                        <li><a href="#!">Psihologija</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div className="card mb-4">
                        <div className="card-header">Najnoviji tekstovi</div>
                        <div className="card-body">You can put anything you want inside of these side widgets. They are easy to use, and feature the Bootstrap 5 card component!</div>
                    </div>
                </div>
            </div>
        </div>
     </div>
     
     </div>
     
    
  )
}

export default Home
