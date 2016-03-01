module.exports = function(grunt){

    "use strict";
    require("matchdep").filterDev("grunt-*").forEach(grunt.loadNpmTasks);

    grunt.initConfig({

        pkg: grunt.file.readJSON('package.json'),

        cssc: {
            build: {
                options: {
                    sortSelectors: true,
                    lineBreaks: true,
                    sortDeclarations:true,
                    consolidateViaDeclarations:false,
                    consolidateViaSelectors:false,
                    consolidateMediaQueries:false
                },
                files: {
                    'resources/css/site.css': 'resources/css/site.css',
                    'resources/css/pages/home.css': 'resources/css/pages/home.css'
                }
            }
        },

        cssmin: {
            build: {
                src: 'resources/css/site.css',
                dest: 'resources/compiled/<%= pkg.name %>.min.css'
            }
        },

        sass: {
            build: {
                files: {
                    'resources/css/site.css': 'resources/sass/site.scss',
                    'resources/css/pages/home.css': 'resources/sass/pages/home.scss'
                }
            }
        },

        watch: {

            js: {
                files: ['resources/js/<%= pkg.name %>.js'],
                tasks: ['uglify']
            },
            css: {
                files: ['resources/sass/**/*.scss'],
                tasks: ['buildcss']
            },
            livereload: {
                files: ['*.jsp','resources/css/*.css','resources/js/*.js'],
                options: {
                    livereload: true
                }
            }
        },

        uglify: {
            build: {
                files: {
                    'resources/compiled/<%= pkg.name %>.min.js': [
                        'resources/js/bootstrap/dropdown.js',
                        'resources/js/bootstrap/affix.js',
                        'resources/js/bootstrap/alert.js',
                        'resources/js/bootstrap/buttons.js',
                        'resources/js/bootstrap/carousel.js',
                        'resources/js/bootstrap/collapse.js',
                        'resources/js/bootstrap/popover.js',
                        'resources/js/bootstrap/scrollspy.js',
                        'resources/js/bootstrap/tab.js',
                        'resources/js/bootstrap/tooltip.js',
                        'resources/js/bootstrap/transition.js'
                    ]
                }
            }
        }

    });




    // These plugins provide necessary tasks.
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-sass');
    grunt.loadNpmTasks('grunt-cssc');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-watch');

    grunt.registerTask('default', ['sass', 'uglify', 'cssc', 'cssmin']);
    grunt.registerTask('buildcss',  ['sass', 'cssc', 'cssmin']);

};