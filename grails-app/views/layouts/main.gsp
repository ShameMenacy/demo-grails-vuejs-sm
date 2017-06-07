<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
    <script src="https://unpkg.com/vue@2.3.3/dist/vue.js"></script>
    <script src="https://unpkg.com/axios@0.16.1/dist/axios.min.js"></script>
    <!--vuetable-2-->
    <script src="https://unpkg.com/vuetable-2@1.6.0"></script>
    <asset:stylesheet src="application.css"/>
    <g:layoutHead/>
</head>
<body>
<div class="container-fluid h-100">
    <div class="row h-100">
        <!-- left sidebar -->
        <div class="col-md-2 fixed pl-0 py-3 bg-faded">
            <ul class="nav flex-md-column justify-content-center">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
            </ul>
        </div>
        <!-- center content -->
        <div class="col fluid d-flex flex-column p-0">
            <nav id="topNav" class="navbar navbar-toggleable-md navbar-inverse bg-primary">
                <button class="navbar-toggler navbar-toggler-right py-2" type="button" data-toggle="collapse"
                        data-target="#collapsingNavbar">
                    ☰
                </button>
                <a class="navbar-brand" href="#first">Bootstrap 4</a>
                <div class="collapse navbar-collapse" id="collapsingNavbar">
                    <ul class="nav navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link page-scroll" data-toggle="modal" title="A free Bootstrap theme"
                               href="#aboutModal">About</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <!-- main content -->
            <div id="app" role="main" class="flex-grow">
                <div class="col-12 py-4">
                    <g:layoutBody/>
                    <h3 class="text-primary hidden-sm-down">Lorem Ipsum
                        <span class="small">"Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."</span>
                    </h3>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been
                        the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley
                        of type and scrambled it to make a type specimen book. It has survived not only five centuries,
                        but also the leap into electronic typesetting, remaining essentially unchanged. It was
                        popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,
                        and more recently with desktop publishing software like Aldus PageMaker including versions of
                        Lorem Ipsum.</p>
                    <div class="row">
                        <div class="col-xl-3 col-md-6">
                            <div class="card card-block mb-2">
                                <h2 class="text-center"><span class="label label-danger">Snippets</span></h2>
                                <h1 class="text-center">311</h1>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6 mb-2">
                            <div class="card card-block">
                                <h2 class="text-center"><span class="label label-danger">Downloads</span></h2>
                                <h1 class="text-center">982</h1>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6 mb-2">
                            <div class="card card-block">
                                <h2 class="text-center"><span class="label label-danger">Sales</span></h2>
                                <h1 class="text-center">112</h1>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6 mb-2">
                            <div class="card card-block">
                                <h2 class="text-center"><span class="label label-danger">Questions</span></h2>
                                <h1 class="text-center">209</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /main content -->
            <nav class="navbar fixed-bottom navbar-light bg-faded">
                <footer class="navbar navbar-toggleable-xl navbar-faded navbar-light">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a href="#" class="nav-link">Footer</a></li>
                        <li class="nav-item"><a href="#" class="nav-link">Link</a></li>
                        <li class="nav-item"><a href="#" class="nav-link">Link</a></li>
                        <li class="nav-item"><a href="#" class="nav-link">More</a></li>
                    </ul>
                </footer>
            </nav>

        </div>

        <!-- right sidebar -->
        <div class="col-md-2 fixed py-3 bg-faded">
            <div class="card card-block mb-2 border-0">
                Put some content here in the sidebar like ads or links.
            </div>
            <div class="card card-block mb-2 border-0">
                Put some content here in the sidebar like ads or links.
            </div>
            <div class="card card-block mb-2 border-0">
                Put some content here in the sidebar like ads or links.
            </div>
        </div>
    </div>
</div>
<div id="aboutModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            </div>
            <div class="modal-body">
                <p>One fine modal body…</p>
            </div>
            <div class="modal-footer">
                <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
